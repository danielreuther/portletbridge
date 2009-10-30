/*
 * Copyright 2001-2004 The Apache Software Foundation.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.portletbridge.portlet;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author jmccrindle
 */
public class DefaultValidationMemento<K, V> implements ValidationMemento<K, V>, Serializable {

    /**
     * default serial version id 
     */
    private static final long serialVersionUID = 5856458092122115180L;

    private final ConcurrentMap<String, Map<K, V>> validationInfoMap =
        new ConcurrentHashMap<String, Map<K, V>>();
    
    /**
     * Default Constructor
     */
    public DefaultValidationMemento() {
        super();
    }

    /* (non-Javadoc)
     * @see org.portletbridge.portlet.ValidationMemento#getValidationInfo(java.lang.String)
     */
    public Map<K, V> remove(String id) {
        Map<K, V> result = validationInfoMap.remove(id);
        return result;
    }

    /* (non-Javadoc)
     * @see org.portletbridge.portlet.ValidationMemento#put(java.lang.String, java.util.Map)
     */
    public void put(String id, Map<K, V> map) {
        validationInfoMap.putIfAbsent(id, map);
    }

}
