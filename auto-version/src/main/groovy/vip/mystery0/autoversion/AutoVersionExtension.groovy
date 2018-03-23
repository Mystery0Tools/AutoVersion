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

class AutoVersionExtension {
	int major = 0
	int minor = 0
	int patch = 0
	int beta = 0
	int alpha = 0
	int build = -1
	String branch = ""

	public <T> void setMajor(T number) {
		major = validate(number)
	}

	public <T> void setPatch(T number) {
		patch = validate(number)
	}

	public <T> void setBuild(T number) {
		build = validate(number)
	}

	public void setBranch(String branch) {
		this.branch = branch
	}

	public def getBranch() {
		if (branch == "")
			branch = Utils.branchName
		return branch
	}

	public def getBuild() {
		if (build == -1)
			build = Utils.commitCount
		return build
	}

	public Integer getCode() {
		if (build == -1)
			build = Utils.commitCount
		return build
	}

	public String getName() {
		def versionName
		if (beta != 0) {
			versionName = "${major}.${minor}.${patch}-beta${beta}"
		} else if (alpha != 0) {
			versionName = "${major}.${minor}.${patch}-alpha${alpha}"
		} else {
			versionName = "${major}.${minor}.${patch}"
		}
		return versionName
	}

	private static <T> int validate(T number) {
		def intNumber
		try {
			intNumber = number.toInteger()
		} catch (Exception e) {
			e.printStackTrace()
			return 0
		}
		if (intNumber < 0) {
			return 0
		}
		return intNumber
	}
}