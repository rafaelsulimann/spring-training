package br.com.sulimann.builder.utils;

public class SqlQueryBuilder {

  private final StringBuilder query;
  private boolean hasSelect;
  private boolean hasFrom;
  private boolean hasWhere;

  private SqlQueryBuilder() {
    this.query = new StringBuilder();
    this.hasSelect = false;
    this.hasFrom = false;
    this.hasWhere = false;
  }

  public static SqlQueryBuilder create() {
    return new SqlQueryBuilder();
  }

  public SqlQueryBuilder select(String... columns) {
    if (hasSelect) {
      throw new IllegalStateException("SELECT já foi utilizado na query");
    }
    query.append("SELECT ");
    var count = 1;
    for (String column : columns) {
      query.append(column);
      if (count < columns.length) {
        query.append(", ");
      }
      count++;
    }
    hasSelect = true;
    return this;
  }

  public SqlQueryBuilder from(String table) {
    if (!hasSelect) {
      throw new IllegalStateException("FROM deve ser usado após SELECT");
    }
    if (hasFrom) {
      throw new IllegalStateException("FROM já foi utilizado na query");
    }
    query.append(" FROM ").append(table);
    hasFrom = true;
    return this;
  }

  public SqlQueryBuilder where(String condition) {
    if (!hasFrom) {
      throw new IllegalStateException("WHERE deve ser usado após FROM");
    }
    if (hasWhere) {
      throw new IllegalStateException("WHERE já foi utilizado na query");
    }
    query.append(" WHERE ").append(condition);
    hasWhere = true;
    return this;
  }

  public SqlQueryBuilder and(String condition) {
    if (!hasWhere) {
      throw new IllegalStateException("AND deve ser usado após WHERE");
    }
    query.append(" AND ").append(condition);
    return this;
  }

  public SqlQueryBuilder or(String condition) {
    if (!hasWhere) {
      throw new IllegalStateException("OR deve ser usado após WHERE");
    }
    query.append(" OR ").append(condition);
    return this;
  }

  public SqlQueryBuilder orderBy(String column, String order) {
    if (!hasFrom) {
      throw new IllegalStateException("ORDER BY deve ser usado após FROM");
    }
    query.append(" ORDER BY ").append(column).append(" ").append(order);
    return this;
  }

  public String build() {
    if (!hasSelect || !hasFrom) {
      throw new IllegalStateException("Query incompleta: SELECT e FROM são obrigatórios");
    }
    return query.toString();
  }
}
