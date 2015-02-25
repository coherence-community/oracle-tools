/*
 * File: ExtendClient.java
 *
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * The contents of this file are subject to the terms and conditions of 
 * the Common Development and Distribution License 1.0 (the "License").
 *
 * You may not use this file except in compliance with the License.
 *
 * You can obtain a copy of the License by consulting the LICENSE.txt file
 * distributed with this file, or by consulting https://oss.oracle.com/licenses/CDDL
 *
 * See the License for the specific language governing permissions
 * and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file LICENSE.txt.
 *
 * MODIFICATIONS:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 */

package com.oracle.tools.junit;

import com.oracle.tools.runtime.LocalPlatform;
import com.oracle.tools.runtime.coherence.CoherenceCacheServerSchema;
import com.tangosol.net.ConfigurableCacheFactory;
import com.tangosol.net.ScopedCacheFactoryBuilder;

import java.util.Properties;

/**
 * A {@link SessionBuilder} for Coherence *Extend Clients.
 * <p>
 * Copyright (c) 2015. All Rights Reserved. Oracle Corporation.<br>
 * Oracle is a registered trademark of Oracle Corporation and/or its affiliates.
 *
 * @author Brian Oliver
 */
public class ExtendClient implements SessionBuilder
{
    /**
     * The Coherence Cache Configuration URI to use for the {@link ExtendClient}.
     */
    private String cacheConfigURI;


    /**
     * Creates an {@link ExtendClient} for the specified Cache Configuration URI.
     *
     * @param cacheConfigURI  the cache configuration URI
     */
    public ExtendClient(String cacheConfigURI)
    {
        this.cacheConfigURI = cacheConfigURI;
    }


    @Override
    public ConfigurableCacheFactory realize(LocalPlatform                 platform,
                                            CoherenceClusterOrchestration orchestration,
                                            CoherenceCacheServerSchema    serverSchema)
    {
        // build a schema for a local storage-disabled member
        CoherenceCacheServerSchema schema =
            new CoherenceCacheServerSchema(serverSchema).setRoleName("extend-client").setStorageEnabled(false)
                .setTCMPEnabled(false).setSystemProperty("tangosol.coherence.extend.enabled",
                                                         true).setCacheConfigURI(cacheConfigURI);

        // set the current system properties with those of the schema
        Properties properties = schema.getSystemProperties(platform);

        for (String propertyName : properties.stringPropertyNames())
        {
            System.setProperty(propertyName, properties.getProperty(propertyName));
        }

        return new ScopedCacheFactoryBuilder().getConfigurableCacheFactory(cacheConfigURI, getClass().getClassLoader());
    }
}
