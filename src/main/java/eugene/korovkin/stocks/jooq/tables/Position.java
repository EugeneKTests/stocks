/*
 * This file is generated by jOOQ.
 */
package eugene.korovkin.stocks.jooq.tables;


import eugene.korovkin.stocks.jooq.Keys;
import eugene.korovkin.stocks.jooq.Stocks;
import eugene.korovkin.stocks.jooq.tables.records.PositionRecord;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row3;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Position extends TableImpl<PositionRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>stocks.position</code>
     */
    public static final Position POSITION = new Position();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<PositionRecord> getRecordType() {
        return PositionRecord.class;
    }

    /**
     * The column <code>stocks.position.id</code>.
     */
    public final TableField<PositionRecord, UUID> ID = createField(DSL.name("id"), SQLDataType.UUID.nullable(false), this, "");

    /**
     * The column <code>stocks.position.company_id</code>.
     */
    public final TableField<PositionRecord, UUID> COMPANY_ID = createField(DSL.name("company_id"), SQLDataType.UUID, this, "");

    /**
     * The column <code>stocks.position.quantity</code>.
     */
    public final TableField<PositionRecord, Integer> QUANTITY = createField(DSL.name("quantity"), SQLDataType.INTEGER, this, "");

    private Position(Name alias, Table<PositionRecord> aliased) {
        this(alias, aliased, null);
    }

    private Position(Name alias, Table<PositionRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>stocks.position</code> table reference
     */
    public Position(String alias) {
        this(DSL.name(alias), POSITION);
    }

    /**
     * Create an aliased <code>stocks.position</code> table reference
     */
    public Position(Name alias) {
        this(alias, POSITION);
    }

    /**
     * Create a <code>stocks.position</code> table reference
     */
    public Position() {
        this(DSL.name("position"), null);
    }

    public <O extends Record> Position(Table<O> child, ForeignKey<O, PositionRecord> key) {
        super(child, key, POSITION);
    }

    @Override
    public Schema getSchema() {
        return Stocks.STOCKS;
    }

    @Override
    public UniqueKey<PositionRecord> getPrimaryKey() {
        return Keys.POSITION_PKEY;
    }

    @Override
    public List<UniqueKey<PositionRecord>> getKeys() {
        return Arrays.<UniqueKey<PositionRecord>>asList(Keys.POSITION_PKEY);
    }

    @Override
    public List<ForeignKey<PositionRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<PositionRecord, ?>>asList(Keys.POSITION__POSITION_COMPANY_ID_FKEY);
    }

    private transient Company _company;

    public Company company() {
        if (_company == null)
            _company = new Company(this, Keys.POSITION__POSITION_COMPANY_ID_FKEY);

        return _company;
    }

    @Override
    public Position as(String alias) {
        return new Position(DSL.name(alias), this);
    }

    @Override
    public Position as(Name alias) {
        return new Position(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Position rename(String name) {
        return new Position(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Position rename(Name name) {
        return new Position(name, null);
    }

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row3<UUID, UUID, Integer> fieldsRow() {
        return (Row3) super.fieldsRow();
    }
}
