/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.kairos.kafka.workshop.avro;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class AvroItem extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -4790395166032626898L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"AvroItem\",\"namespace\":\"com.kairos.kafka.workshop.avro\",\"fields\":[{\"name\":\"id\",\"type\":\"long\"},{\"name\":\"name\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"quantity\",\"type\":\"int\"},{\"name\":\"updateTimestamp\",\"type\":\"long\",\"logicalType\":\"timestamp-millis\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<AvroItem> ENCODER =
      new BinaryMessageEncoder<AvroItem>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<AvroItem> DECODER =
      new BinaryMessageDecoder<AvroItem>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<AvroItem> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<AvroItem> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<AvroItem>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this AvroItem to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a AvroItem from a ByteBuffer. */
  public static AvroItem fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

   private long id;
   private java.lang.String name;
   private int quantity;
   private long updateTimestamp;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public AvroItem() {}

  /**
   * All-args constructor.
   * @param id The new value for id
   * @param name The new value for name
   * @param quantity The new value for quantity
   * @param updateTimestamp The new value for updateTimestamp
   */
  public AvroItem(java.lang.Long id, java.lang.String name, java.lang.Integer quantity, java.lang.Long updateTimestamp) {
    this.id = id;
    this.name = name;
    this.quantity = quantity;
    this.updateTimestamp = updateTimestamp;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return id;
    case 1: return name;
    case 2: return quantity;
    case 3: return updateTimestamp;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: id = (java.lang.Long)value$; break;
    case 1: name = (java.lang.String)value$; break;
    case 2: quantity = (java.lang.Integer)value$; break;
    case 3: updateTimestamp = (java.lang.Long)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'id' field.
   * @return The value of the 'id' field.
   */
  public java.lang.Long getId() {
    return id;
  }


  /**
   * Gets the value of the 'name' field.
   * @return The value of the 'name' field.
   */
  public java.lang.String getName() {
    return name;
  }


  /**
   * Gets the value of the 'quantity' field.
   * @return The value of the 'quantity' field.
   */
  public java.lang.Integer getQuantity() {
    return quantity;
  }


  /**
   * Gets the value of the 'updateTimestamp' field.
   * @return The value of the 'updateTimestamp' field.
   */
  public java.lang.Long getUpdateTimestamp() {
    return updateTimestamp;
  }


  /**
   * Creates a new AvroItem RecordBuilder.
   * @return A new AvroItem RecordBuilder
   */
  public static com.kairos.kafka.workshop.avro.AvroItem.Builder newBuilder() {
    return new com.kairos.kafka.workshop.avro.AvroItem.Builder();
  }

  /**
   * Creates a new AvroItem RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new AvroItem RecordBuilder
   */
  public static com.kairos.kafka.workshop.avro.AvroItem.Builder newBuilder(com.kairos.kafka.workshop.avro.AvroItem.Builder other) {
    return new com.kairos.kafka.workshop.avro.AvroItem.Builder(other);
  }

  /**
   * Creates a new AvroItem RecordBuilder by copying an existing AvroItem instance.
   * @param other The existing instance to copy.
   * @return A new AvroItem RecordBuilder
   */
  public static com.kairos.kafka.workshop.avro.AvroItem.Builder newBuilder(com.kairos.kafka.workshop.avro.AvroItem other) {
    return new com.kairos.kafka.workshop.avro.AvroItem.Builder(other);
  }

  /**
   * RecordBuilder for AvroItem instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<AvroItem>
    implements org.apache.avro.data.RecordBuilder<AvroItem> {

    private long id;
    private java.lang.String name;
    private int quantity;
    private long updateTimestamp;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.kairos.kafka.workshop.avro.AvroItem.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.name)) {
        this.name = data().deepCopy(fields()[1].schema(), other.name);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.quantity)) {
        this.quantity = data().deepCopy(fields()[2].schema(), other.quantity);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.updateTimestamp)) {
        this.updateTimestamp = data().deepCopy(fields()[3].schema(), other.updateTimestamp);
        fieldSetFlags()[3] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing AvroItem instance
     * @param other The existing instance to copy.
     */
    private Builder(com.kairos.kafka.workshop.avro.AvroItem other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.name)) {
        this.name = data().deepCopy(fields()[1].schema(), other.name);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.quantity)) {
        this.quantity = data().deepCopy(fields()[2].schema(), other.quantity);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.updateTimestamp)) {
        this.updateTimestamp = data().deepCopy(fields()[3].schema(), other.updateTimestamp);
        fieldSetFlags()[3] = true;
      }
    }

    /**
      * Gets the value of the 'id' field.
      * @return The value.
      */
    public java.lang.Long getId() {
      return id;
    }

    /**
      * Sets the value of the 'id' field.
      * @param value The value of 'id'.
      * @return This builder.
      */
    public com.kairos.kafka.workshop.avro.AvroItem.Builder setId(long value) {
      validate(fields()[0], value);
      this.id = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'id' field has been set.
      * @return True if the 'id' field has been set, false otherwise.
      */
    public boolean hasId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'id' field.
      * @return This builder.
      */
    public com.kairos.kafka.workshop.avro.AvroItem.Builder clearId() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'name' field.
      * @return The value.
      */
    public java.lang.String getName() {
      return name;
    }

    /**
      * Sets the value of the 'name' field.
      * @param value The value of 'name'.
      * @return This builder.
      */
    public com.kairos.kafka.workshop.avro.AvroItem.Builder setName(java.lang.String value) {
      validate(fields()[1], value);
      this.name = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'name' field has been set.
      * @return True if the 'name' field has been set, false otherwise.
      */
    public boolean hasName() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'name' field.
      * @return This builder.
      */
    public com.kairos.kafka.workshop.avro.AvroItem.Builder clearName() {
      name = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'quantity' field.
      * @return The value.
      */
    public java.lang.Integer getQuantity() {
      return quantity;
    }

    /**
      * Sets the value of the 'quantity' field.
      * @param value The value of 'quantity'.
      * @return This builder.
      */
    public com.kairos.kafka.workshop.avro.AvroItem.Builder setQuantity(int value) {
      validate(fields()[2], value);
      this.quantity = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'quantity' field has been set.
      * @return True if the 'quantity' field has been set, false otherwise.
      */
    public boolean hasQuantity() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'quantity' field.
      * @return This builder.
      */
    public com.kairos.kafka.workshop.avro.AvroItem.Builder clearQuantity() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'updateTimestamp' field.
      * @return The value.
      */
    public java.lang.Long getUpdateTimestamp() {
      return updateTimestamp;
    }

    /**
      * Sets the value of the 'updateTimestamp' field.
      * @param value The value of 'updateTimestamp'.
      * @return This builder.
      */
    public com.kairos.kafka.workshop.avro.AvroItem.Builder setUpdateTimestamp(long value) {
      validate(fields()[3], value);
      this.updateTimestamp = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'updateTimestamp' field has been set.
      * @return True if the 'updateTimestamp' field has been set, false otherwise.
      */
    public boolean hasUpdateTimestamp() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'updateTimestamp' field.
      * @return This builder.
      */
    public com.kairos.kafka.workshop.avro.AvroItem.Builder clearUpdateTimestamp() {
      fieldSetFlags()[3] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public AvroItem build() {
      try {
        AvroItem record = new AvroItem();
        record.id = fieldSetFlags()[0] ? this.id : (java.lang.Long) defaultValue(fields()[0]);
        record.name = fieldSetFlags()[1] ? this.name : (java.lang.String) defaultValue(fields()[1]);
        record.quantity = fieldSetFlags()[2] ? this.quantity : (java.lang.Integer) defaultValue(fields()[2]);
        record.updateTimestamp = fieldSetFlags()[3] ? this.updateTimestamp : (java.lang.Long) defaultValue(fields()[3]);
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<AvroItem>
    WRITER$ = (org.apache.avro.io.DatumWriter<AvroItem>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<AvroItem>
    READER$ = (org.apache.avro.io.DatumReader<AvroItem>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
