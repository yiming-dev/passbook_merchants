CREATE TABLE `merchants`(
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(64) COLLATE utf8_bin NOT NULL COMMENT 'Merchants Name',
  `logo_url` VARCHAR(256) COLLATE utf8_bin NOT NULL COMMENT 'Merchants Logo',
  `business_licenses_url` VARCHAR(256) COLLATE utf8_bin NOT NULL COMMENT 'Merchants License',
  `phone` VARCHAR(64) COLLATE utf8_bin NOT NULL COMMENT 'Merchants phone',
  `address` VARCHAR(64) COLLATE utf8_bin NOT NULL COMMENT 'Merchants Address',
  `is_audit` BOOLEAN NOT NULL COMMENT 'Merchants legit',
  PRIMARY KEY (`id`)
)ENGINE=INNODB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;