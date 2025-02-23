package com.webflux.practice.jsonconverter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.dialect.Dialect;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.type.descriptor.converter.spi.BasicValueConverter;
import org.hibernate.type.descriptor.jdbc.JdbcType;
import org.hibernate.type.spi.TypeConfiguration;
import org.hibernate.usertype.UserType;

import java.io.IOException;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Map;
import java.util.Objects;

public class JsonType implements UserType<Map> {
    private final ObjectMapper objectMapper = new ObjectMapper();


    @Override
    public int getSqlType() {
        return 0;
    }

    @Override
    public Class<Map> returnedClass() {
        return Map.class;
    }

    @Override
    public boolean equals(Map stringObjectMap, Map j1) {
        return Objects.equals(stringObjectMap,j1);
    }

    @Override
    public int hashCode(Map stringObjectMap) {
        return Objects.hashCode(stringObjectMap);
    }

    @Override
    public Map nullSafeGet(ResultSet resultSet, int i, SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws SQLException {
        String json = resultSet.getString(i);
        if (json == null) {
            return null;
        }
        try {
            return objectMapper.readValue(json, Map.class); // Deserialize JSON to Map
        } catch (IOException e) {
            throw new SQLException("Failed to deserialize JSON", e);
        }
    }

    @Override
    public void nullSafeSet(PreparedStatement preparedStatement, Map stringObjectMap, int i, SharedSessionContractImplementor sharedSessionContractImplementor) throws SQLException {
        if (stringObjectMap == null) {
            preparedStatement.setNull(i, Types.VARCHAR);
        } else {
            try {
                String json = objectMapper.writeValueAsString(stringObjectMap); // Serialize Map to JSON
                preparedStatement.setString(i, json);
            } catch (IOException e) {
                throw new SQLException("Failed to serialize JSON", e);
            }
        }
    }

    @Override
    public Map deepCopy(Map stringObjectMap) {
        if (stringObjectMap == null) {
            return null;
        }
        try {
            return objectMapper.readValue(objectMapper.writeValueAsString(stringObjectMap), Map.class);
        } catch (IOException e) {
            throw new RuntimeException("Failed to deep copy JSON", e);
        }
    }

    @Override
    public boolean isMutable() {
        return true;
    }

    @Override
    public Serializable disassemble(Map stringObjectMap) {
        return (Serializable) deepCopy(stringObjectMap);
    }

    @Override
    public Map assemble(Serializable serializable, Object o) {
        return deepCopy((Map) serializable);
    }

    @Override
    public Map replace(Map detached, Map managed, Object owner) {
        return UserType.super.replace(detached, managed, owner);
    }

    @Override
    public long getDefaultSqlLength(Dialect dialect, JdbcType jdbcType) {
        return UserType.super.getDefaultSqlLength(dialect, jdbcType);
    }

    @Override
    public int getDefaultSqlPrecision(Dialect dialect, JdbcType jdbcType) {
        return UserType.super.getDefaultSqlPrecision(dialect, jdbcType);
    }

    @Override
    public int getDefaultSqlScale(Dialect dialect, JdbcType jdbcType) {
        return UserType.super.getDefaultSqlScale(dialect, jdbcType);
    }

    @Override
    public JdbcType getJdbcType(TypeConfiguration typeConfiguration) {
        return UserType.super.getJdbcType(typeConfiguration);
    }

    @Override
    public BasicValueConverter<Map, Object> getValueConverter() {
        return UserType.super.getValueConverter();
    }
}
