package com.example.gitlist.model

import java.io.Serializable

data class OwnerDetails(val name: String,
                        val owner: List<Details>
): Serializable
