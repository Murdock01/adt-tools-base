/*
 * Copyright (C) 2015 The Android Open Source Project
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

package com.android.build.gradle.integration.performance;

import static com.android.build.gradle.integration.performance.BenchmarkMode.EVALUATION;

import com.android.build.gradle.integration.common.fixture.GradleTestProject;
import com.android.build.gradle.integration.common.fixture.app.JavaGradleModule;
import com.android.build.gradle.integration.common.fixture.app.LargeTestProject;

import org.junit.Rule;
import org.junit.Test;

/**
 * test with ~30 projects that evaluates the projects
 */
public class SmallJavaEvaluationTest {

    @Rule
    public GradleTestProject project = GradleTestProject.builder()
            .fromTestApp(LargeTestProject.builder()
                    .withModule(JavaGradleModule.class)
                    .withDepth(LargeTestProject.SMALL_DEPTH)
                    .withBreadth(LargeTestProject.SMALL_BREADTH)
                    .create())
            .create();

    @Test
    public void projectsTaskRunOn30Projects() {
        project.executeWithBenchmark("MediumJava", EVALUATION, "projects");
    }
}
