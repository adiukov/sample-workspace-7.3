create index IX_FC930CDD on PetsCatalog_Pet (companyId);
create index IX_8E7C5685 on PetsCatalog_Pet (groupId, status);
create index IX_6CDDD8B on PetsCatalog_Pet (userId, status);
create index IX_DEDD339F on PetsCatalog_Pet (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_AB0C15E1 on PetsCatalog_Pet (uuid_[$COLUMN_LENGTH:75$], groupId);