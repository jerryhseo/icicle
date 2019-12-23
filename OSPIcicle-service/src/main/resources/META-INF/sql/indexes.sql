create index IX_C56D2B37 on ICICLE_Icebreaker (groupId, status);
create index IX_FA0DB55F on ICICLE_Icebreaker (status);
create index IX_56CFC03C on ICICLE_Icebreaker (type_[$COLUMN_LENGTH:75$]);
create index IX_8606F52D on ICICLE_Icebreaker (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_3934E2EF on ICICLE_Icebreaker (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_2602206B on ICICLE_IcebreakerEntry (groupId, status);
create index IX_5F7A55AB on ICICLE_IcebreakerEntry (status);
create index IX_A467E670 on ICICLE_IcebreakerEntry (type_[$COLUMN_LENGTH:75$]);
create index IX_F96EFF on ICICLE_IcebreakerEntry (userId);
create index IX_3810A679 on ICICLE_IcebreakerEntry (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_3C52773B on ICICLE_IcebreakerEntry (uuid_[$COLUMN_LENGTH:75$], groupId);