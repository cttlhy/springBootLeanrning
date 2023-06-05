package com.mini.beans;

import java.util.*;

public class ArgumentValues {
    private final Map<Integer,ArgumentValue> argumentValues = new HashMap<>(0);
    private final List<ArgumentValue> genericArgumentValues = new LinkedList<>();

    public ArgumentValues() {
    }
    private void addArgumentValue(Integer key, ArgumentValue argumentValue) {
        argumentValues.put(key,argumentValue);
    }

    public boolean hasIndexedArgumentValue(Integer key) {
        return argumentValues.containsKey(key);
    }

    public ArgumentValue getIndexedArgumentValue(Integer key) {
        return argumentValues.get(key);
    }

    public void addGenericArgumentValue(Object value,String type) {
        genericArgumentValues.add(new ArgumentValue(value,type));
    }

    public void addGenericArgumentValue(ArgumentValue argumentValue) {
        if (argumentValue.getName() != null) {
            for (Iterator<ArgumentValue> it =
                 this.genericArgumentValues.iterator(); it.hasNext(); ) {
                ArgumentValue av = it.next();
                if (av.getName().equals(argumentValue.getName())) {
                    it.remove();
                }
            }
        }
        this.genericArgumentValues.add(argumentValue);
    }

    public ArgumentValue getGenericArgumentValue(String requiredName) {
        for (ArgumentValue valueHolder : this.genericArgumentValues) {
            if (valueHolder != null && (requiredName == null ||
                    (!requiredName.equals(valueHolder.getName())))) {
                continue;
            }
            return valueHolder;
        }
        return null;
    }

    public int getArgumentCount() {
        return this.genericArgumentValues.size();
    }

    public boolean isEmpty() {
        return this.genericArgumentValues.isEmpty();
    }
}
