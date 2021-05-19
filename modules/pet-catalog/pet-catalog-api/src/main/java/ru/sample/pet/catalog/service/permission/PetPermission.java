package ru.sample.pet.catalog.service.permission;

import com.liferay.exportimport.kernel.staging.permission.StagingPermissionUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.PortletProvider;
import com.liferay.portal.kernel.portlet.PortletProviderUtil;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.BaseModelPermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.spring.osgi.OSGiBeanProperties;
import com.liferay.portal.kernel.workflow.permission.WorkflowPermissionUtil;

import ru.sample.pet.catalog.model.Pet;
import ru.sample.pet.catalog.service.PetLocalServiceUtil;

/**
 * Класс для проверки прав доступа к конкретному объекту - в нашем случае Pet -
 * питомец
 * 
 * @author akakunin
 * 
 */
@OSGiBeanProperties(
		property = {"model.class.name=ru.emdev.samples.petcatalog.model.Pet"}
	)
public class PetPermission implements BaseModelPermissionChecker {

    public static void check(
            PermissionChecker permissionChecker, long petId,
            String actionId)
        throws PortalException {

        if (!contains(permissionChecker, petId, actionId)) {
        	throw new PrincipalException.MustHavePermission(
    				permissionChecker, Pet.class.getName(),
    				petId, actionId);
        }
    }

    public static void check(
            PermissionChecker permissionChecker, Pet pet,
            String actionId)
        throws PortalException {

        if (!contains(permissionChecker, pet, actionId)) {
        	throw new PrincipalException.MustHavePermission(
    				permissionChecker, Pet.class.getName(),
    				pet.getPetId(), actionId);
        }
    }

    public static boolean contains(
            PermissionChecker permissionChecker, long petId,
            String actionId) throws PortalException {

        Pet pet = PetLocalServiceUtil.getPet(petId);

        return contains(permissionChecker, pet, actionId);
    }

    public static boolean contains(
            PermissionChecker permissionChecker, Pet pet,
            String actionId) {

    	String portletId = PortletProviderUtil.getPortletId(
    			Pet.class.getName(), PortletProvider.Action.EDIT);
    	
    	Boolean hasPermission = StagingPermissionUtil.hasPermission(
    			permissionChecker, pet.getGroupId(), Pet.class.getName(),
    			pet.getPetId(), portletId, actionId);

    		if (hasPermission != null) {
    			return hasPermission.booleanValue();
    		}

    		if (pet.isDraft() || pet.isScheduled()) {
    			if (actionId.equals(ActionKeys.VIEW) &&
    				!contains(permissionChecker, pet, ActionKeys.UPDATE)) {

    				return false;
    			}
    		} else if (pet.isPending()) {
    			hasPermission = WorkflowPermissionUtil.hasPermission(
    				permissionChecker, pet.getGroupId(),
    				Pet.class.getName(), pet.getPetId(), actionId);

    			if (hasPermission != null) {
    				return hasPermission.booleanValue();
    			}
    		}
    		
        // Владелец объекта (тот кто прописан в его userId) может делать с ним
        // все.
        if (permissionChecker.hasOwnerPermission(
                pet.getCompanyId(), Pet.class.getName(),
                pet.getPetId(), pet.getUserId(), actionId)) {

            return true;
        }

        // проверяем права доступа
        return permissionChecker.hasPermission(
                pet.getGroupId(), Pet.class.getName(),
                pet.getPetId(), actionId);
    }
    
    @Override
	public void checkBaseModel(
			PermissionChecker permissionChecker, long groupId, long primaryKey,
			String actionId)
		throws PortalException {

		check(permissionChecker, primaryKey, actionId);
	}
}
