/*
 * This file is generated by jOOQ.
 */
package eugene.korovkin.stocks.jooq.tables.records;


import eugene.korovkin.stocks.jooq.tables.Position;

import java.util.UUID;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class PositionRecord extends UpdatableRecordImpl<PositionRecord> implements Record3<UUID, UUID, Integer> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>stocks.position.id</code>.
     */
    public void setId(UUID value) {
        set(0, value);
    }

    /**
     * Getter for <code>stocks.position.id</code>.
     */
    public UUID getId() {
        return (UUID) get(0);
    }

    /**
     * Setter for <code>stocks.position.company_id</code>.
     */
    public void setCompanyId(UUID value) {
        set(1, value);
    }

    /**
     * Getter for <code>stocks.position.company_id</code>.
     */
    public UUID getCompanyId() {
        return (UUID) get(1);
    }

    /**
     * Setter for <code>stocks.position.quantity</code>.
     */
    public void setQuantity(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>stocks.position.quantity</code>.
     */
    public Integer getQuantity() {
        return (Integer) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<UUID> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row3<UUID, UUID, Integer> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    @Override
    public Row3<UUID, UUID, Integer> valuesRow() {
        return (Row3) super.valuesRow();
    }

    @Override
    public Field<UUID> field1() {
        return Position.POSITION.ID;
    }

    @Override
    public Field<UUID> field2() {
        return Position.POSITION.COMPANY_ID;
    }

    @Override
    public Field<Integer> field3() {
        return Position.POSITION.QUANTITY;
    }

    @Override
    public UUID component1() {
        return getId();
    }

    @Override
    public UUID component2() {
        return getCompanyId();
    }

    @Override
    public Integer component3() {
        return getQuantity();
    }

    @Override
    public UUID value1() {
        return getId();
    }

    @Override
    public UUID value2() {
        return getCompanyId();
    }

    @Override
    public Integer value3() {
        return getQuantity();
    }

    @Override
    public PositionRecord value1(UUID value) {
        setId(value);
        return this;
    }

    @Override
    public PositionRecord value2(UUID value) {
        setCompanyId(value);
        return this;
    }

    @Override
    public PositionRecord value3(Integer value) {
        setQuantity(value);
        return this;
    }

    @Override
    public PositionRecord values(UUID value1, UUID value2, Integer value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached PositionRecord
     */
    public PositionRecord() {
        super(Position.POSITION);
    }

    /**
     * Create a detached, initialised PositionRecord
     */
    public PositionRecord(UUID id, UUID companyId, Integer quantity) {
        super(Position.POSITION);

        setId(id);
        setCompanyId(companyId);
        setQuantity(quantity);
    }
}
