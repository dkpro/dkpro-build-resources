/*
 * Licensed to the Technische Universität Darmstadt under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The Technische Universität Darmstadt
 * licenses this file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// Copyright year property not set -> degrade to the inception year alone.
//
// Deliberately NOT the current year: deriving it here would make the rendered
// NOTICE.txt differ between builds of the same release tag. Projects that want
// a range up to the present set dkpro.copyright.year explicitly - the DKPro
// parent POM does this on behalf of the projects that inherit from it.
def notice = new File(basedir, 'target/maven-shared-archive-resources/META-INF/NOTICE.txt')
assert notice.exists() : "NOTICE.txt was not generated"

def text = notice.text

assert !text.contains('${') : "Unresolved Velocity reference in NOTICE.txt:\n${text}"
assert text.contains('Copyright 2013 Test Organization') : \
    "Expected 'Copyright 2013 Test Organization' but got:\n${text}"
assert !text.contains('2013-') : \
    "Expected a single year, not an open or partial range, when dkpro.copyright.year is unset:\n${text}"
