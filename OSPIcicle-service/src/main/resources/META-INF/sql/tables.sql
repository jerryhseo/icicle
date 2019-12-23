create table ICICLE_Icebreaker (
	uuid_ VARCHAR(75) null,
	icebreakerId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	status INTEGER,
	name VARCHAR(75) null,
	type_ VARCHAR(75) null,
	ip VARCHAR(75) null,
	port VARCHAR(75) null,
	ibUserId VARCHAR(75) null,
	ibUserPassword VARCHAR(75) null
);

create table ICICLE_IcebreakerEntry (
	uuid_ VARCHAR(75) null,
	icebreakerEntryId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	status INTEGER,
	name VARCHAR(75) null,
	type_ VARCHAR(75) null,
	ibIp VARCHAR(75) null,
	ibPort VARCHAR(75) null,
	ibUserId VARCHAR(75) null,
	ibUserPassword VARCHAR(75) null,
	description STRING null
);