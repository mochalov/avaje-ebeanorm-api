package com.avaje.ebean.config.dbplatform;

import java.sql.Types;

/**
 * Microsoft SQL Server 2005 specific platform.
 * <p>
 * <ul>
 * <li>supportsGetGeneratedKeys = true</li>
 * <li>Uses LIMIT OFFSET clause</li>
 * <li>Uses [ & ] for quoted identifiers</li>
 * </ul>
 * </p>
 */
public class MsSqlServer2005Platform extends DatabasePlatform {

  public MsSqlServer2005Platform() {
    super();
    this.name = "mssqlserver2005";
    this.sqlLimiter = new MsSqlServer2005SqlLimiter();
    this.dbDdlSyntax.setIdentity("identity(1,1)");
    this.dbIdentity.setIdType(IdType.IDENTITY);
    this.dbIdentity.setSupportsGetGeneratedKeys(true);
    this.dbIdentity.setSupportsIdentity(true);

    this.openQuote = "[";
    this.closeQuote = "]";

    dbTypeMap.put(Types.BOOLEAN, new DbType("bit default 0"));

    dbTypeMap.put(Types.BIGINT, new DbType("numeric", 19));
    dbTypeMap.put(Types.REAL, new DbType("float(16)"));
    dbTypeMap.put(Types.DOUBLE, new DbType("float(32)"));
    dbTypeMap.put(Types.TINYINT, new DbType("smallint"));
    dbTypeMap.put(Types.DECIMAL, new DbType("numeric", 28));

    dbTypeMap.put(Types.BLOB, new DbType("image"));
    dbTypeMap.put(Types.CLOB, new DbType("text"));
    dbTypeMap.put(Types.LONGVARBINARY, new DbType("image"));
    dbTypeMap.put(Types.LONGVARCHAR, new DbType("text"));

    dbTypeMap.put(Types.DATE, new DbType("datetime"));
    dbTypeMap.put(Types.TIME, new DbType("datetime"));
    dbTypeMap.put(Types.TIMESTAMP, new DbType("datetime"));

  }

}
