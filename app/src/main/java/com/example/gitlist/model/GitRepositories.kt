package com.example.gitlist.model

import java.io.Serializable

data class GitRepositories(val total_count: Int,
                           val incomplete_results: Boolean,
                           val items: Array<OwnerDetails>
): Serializable
