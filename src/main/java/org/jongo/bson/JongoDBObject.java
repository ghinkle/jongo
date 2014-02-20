package org.jongo.bson;

import com.mongodb.BasicDBObject;

/**
 * Used for streaming support
 *
 * @author Greg Hinkle
 */
public class JongoDBObject<T> extends BasicDBObject {

    private T object;

    public JongoDBObject() {
    }

    public JongoDBObject(T object) {
        this.object = object;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }


    @Override
    public Object get(String key) {
        if ("_id".equals(key)) {
            return "Generated _id retrieval not supported when using stream serialization";
        }
        return super.get(key);
    }
}