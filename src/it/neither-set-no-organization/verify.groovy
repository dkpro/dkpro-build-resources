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

// Nothing to state -> omit the copyright line entirely rather than emitting a stub.
def notice = new File(basedir, 'target/maven-shared-archive-resources/META-INF/NOTICE.txt')
assert notice.exists() : "NOTICE.txt was not generated"

def text = notice.text

assert !text.contains('${') : "Unresolved Velocity reference in NOTICE.txt:\n${text}"
assert !text.contains('Copyright') : "Expected no copyright line at all but got:\n${text}"
assert text.contains('Consumer Without Any Year Or Organization') : \
    "Expected the project name to still be rendered:\n${text}"
