/*
 * File: ProfilesTest.java
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

package com.oracle.tools.runtime;

import com.oracle.tools.Options;

import com.oracle.tools.example.ExampleProfile;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;

import static org.hamcrest.core.Is.is;

import static org.junit.Assert.assertThat;

/**
 * Tests for {@link Profile}s.
 * <p>
 * Copyright (c) 2016. All Rights Reserved. Oracle Corporation.<br>
 * Oracle is a registered trademark of Oracle Corporation and/or its affiliates.
 *
 * @author Brian Oliver
 */
public class ProfilesTest
{
    /**
     * Ensure that we can load and instantiate Profiles.
     */
    @Test
    public void shouldReturnCreateProfiles()
    {
        System.setProperty("oracletools.profile.example", "hello");

        Options options = Profiles.getProfiles();

        assertThat(options, is(not(nullValue())));
        assertThat(options.asArray().length, is(1));

        ExampleProfile profile = options.get(ExampleProfile.class);

        assertThat(profile, is(not(nullValue())));

        assertThat(profile.getParameters(), is("hello"));

        System.getProperties().remove("oracletools.profile.example");
    }
}
