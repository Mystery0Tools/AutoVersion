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
	boolean isShowBuild = true
	String branch = ""

	void setMajor(int major) {
		this.major = major
	}

	void setMinor(int minor) {
		this.minor = minor
	}

	void setPatch(int patch) {
		this.patch = patch
	}

	void setBeta(int beta) {
		this.beta = beta
	}

	void setAlpha(int alpha) {
		this.alpha = alpha
	}

	void setBuild(int build) {
		this.build = build
	}

	void setIsShowBuild(boolean isShowBuild) {
		this.isShowBuild = isShowBuild
	}

	void setBranch(String branch) {
		this.branch = branch
	}

	def getBranch() {
		if (branch == "")
			branch = Utils.branchName
		return branch
	}

	def getBuild() {
		if (build == -1)
			build = Utils.commitCount
		return build
	}

	Integer getCode() {
		return getBuild()
	}

	String getName() {
		def versionName
		if (beta != 0) {
			versionName = "${major}.${minor}.${patch}-beta${beta}${if (isShowBuild) "(${build})" else ""}"
		} else if (alpha != 0) {
			versionName = "${major}.${minor}.${patch}-alpha${alpha}${if (isShowBuild) "(${build})" else ""}"
		} else {
			versionName = "${major}.${minor}.${patch}${if (isShowBuild) "(${build})" else ""}"
		}
		return versionName
	}
}