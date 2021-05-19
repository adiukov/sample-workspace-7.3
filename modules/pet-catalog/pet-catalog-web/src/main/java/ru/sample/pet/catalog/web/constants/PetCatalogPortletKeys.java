package ru.sample.pet.catalog.web.constants;

/**
 * @author adiukov-dell
 */
public class PetCatalogPortletKeys {

	public static final String PETCATALOGPORTLET =
		"ru_sample_pet_catalog_web_PetCatalogPortlet";
	// пути на JSP сохраняем в константах
	public static final String PORTLET_PATH = "/petcatalog/";
	public static final String VIEW_JSP = PORTLET_PATH + "view.jsp";
	public static final String EDIT_PET_JSP = PORTLET_PATH + "edit-pet.jsp";
	public static final String VIEW_PET_JSP = PORTLET_PATH + "view-pet.jsp";

	// перечисляем используемые параметры и аттрибуты
	public static final String PARAM_PET = "pet";
	public static final String PARAM_PET_ID = "petId";
	public static final String PARAM_PETS = "pets";
	public static final String PARAM_PETS_COUNT = "petsCount";

}