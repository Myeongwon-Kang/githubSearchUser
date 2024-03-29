package com.kang6264.githubsearchuser.data.remote.api.model

class User {
    var login: String? = null
    var id: Int = 0
    var node_id: String? = null
    var avatar_url: String? = null
    var url: String? = null
    var html_url: String? = null
    var followers_url: String? = null
    var following_url: String? = null
    var gists_url: String? = null
    var starred_url: String? = null
    var subscriptions_url: String? = null
    var organizations_url: String? = null
    var repos_url: String? = null
    var events_url: String? = null
    var received_events_url: String? = null
    var type: String? = null
    var site_admin: Boolean = false
    var score: Float = 0f
    var isFavorite: Boolean = false

    inner class Result {
        var total_count: Int = 0
        var incomplete_results: Boolean = false
        var items: List<User> = listOf()
    }
}