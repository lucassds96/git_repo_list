package com.example.gitlist.model

import java.io.Serializable

data class OwnerDetails(val name: String,
                        val owner: Details,
                        val html_url: String,
                        val description: String,
                        val forks_count: Int
): Serializable
