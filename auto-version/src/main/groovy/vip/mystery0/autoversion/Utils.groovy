/*
 * Created by Mystery0 on 18-3-20 下午2:01.
 * Copyright (c) 2018. All Rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package vip.mystery0.autoversion

class Utils {
	static int getCommitCount() {
		try {
			def result = new StringBuilder()
			def error = new StringBuilder()
			def process = 'git rev-list HEAD --count'.execute()
			process.waitForProcessOutput(result, error)
			if (result.isInteger()) {
				return result.toInteger()
			} else {
				return 0
			}
		} catch (Exception e) {
			e.printStackTrace()
		}
		return 0
	}

	static String getBranchName() {
		try {
			return 'git rev-parse --abbrev-ref HEAD'.execute().text.trim()
		} catch (Exception e) {
			e.printStackTrace()
			return "master"
		}
	}
}