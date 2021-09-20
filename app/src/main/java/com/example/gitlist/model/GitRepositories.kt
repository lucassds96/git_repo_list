package com.example.gitlist.model

import java.io.Serializable

data class GitRepositories(val total_count: Int,
                           val incomplete_results: Boolean,
                           val items: List<OwnerDetails>,
                           val html_url: String,
                           val description: String,
                           val forks_count: Int
): Serializable
