package patches.buildTypes

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildFeatures.PullRequests
import jetbrains.buildServer.configs.kotlin.v2019_2.buildFeatures.pullRequests
import jetbrains.buildServer.configs.kotlin.v2019_2.triggers.VcsTrigger
import jetbrains.buildServer.configs.kotlin.v2019_2.triggers.vcs
import jetbrains.buildServer.configs.kotlin.v2019_2.ui.*

/*
This patch script was generated by TeamCity on settings change in UI.
To apply the patch, change the buildType with id = 'Github'
accordingly, and delete the patch script.
*/
changeBuildType(RelativeId("Github")) {
    triggers {
        val trigger1 = find<VcsTrigger> {
            vcs {
                branchFilter = """
                    +:refs/(pull/*)/head
                    -:<default>
                """.trimIndent()
            }
        }
        trigger1.apply {
            branchFilter = "-:<default>"

        }
    }

    features {
        val feature1 = find<PullRequests> {
            pullRequests {
                provider = github {
                    authType = token {
                        token = "credentialsJSON:43afd6e5-6ad5-4d12-a218-cf1547717a7f"
                    }
                    filterTargetBranch = "refs/heads/master"
                    filterAuthorRole = PullRequests.GitHubRoleFilter.EVERYBODY
                }
            }
        }
        feature1.apply {
            provider = github {
                serverUrl = ""
                authType = token {
                    token = "credentialsJSON:90f3b439-6e91-40f7-a086-d4dd8e0ea9b8"
                }
                filterSourceBranch = ""
                filterTargetBranch = "refs/heads/master"
                filterAuthorRole = PullRequests.GitHubRoleFilter.EVERYBODY
            }
        }
    }
}