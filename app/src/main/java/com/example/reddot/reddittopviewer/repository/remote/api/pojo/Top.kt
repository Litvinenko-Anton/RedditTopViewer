package com.example.reddot.reddittopviewer.repository.remote.api.pojo

import com.google.gson.annotations.SerializedName


data class Top(
        @SerializedName("kind") val kind: String?,
        @SerializedName("data") val data: Data
)

data class Data(
        @SerializedName("modhash") val modhash: String?,
        @SerializedName("dist") val dist: Int,
        @SerializedName("children") val children: List<Children>,
        @SerializedName("after") val after: String?,
        @SerializedName("before") val before: String?
)

data class Children(
        @SerializedName("kind") val kind: String?,
        @SerializedName("data") val data: PostData
)

data class PostData(
        @SerializedName("approved_at_utc") val approvedAtUtc: Any?,
        @SerializedName("subreddit") val subreddit: String?,
        @SerializedName("selftext") val selftext: String?,
        @SerializedName("author_fullname") val authorFullname: String?,
        @SerializedName("saved") val saved: Boolean,
        @SerializedName("mod_reason_title") val modReasonTitle: String?,
        @SerializedName("gilded") val gilded: Int,
        @SerializedName("clicked") val clicked: Boolean,
        @SerializedName("title") val title: String?,
        @SerializedName("link_flair_richtext") val linkFlairRichtext: List<Any>,
        @SerializedName("subreddit_name_prefixed") val subredditNamePrefixed: String?,
        @SerializedName("hidden") val hidden: Boolean,
        @SerializedName("pwls") val pwls: Int,
        @SerializedName("link_flair_css_class") val linkFlairCssClass: String?,
        @SerializedName("downs") val downs: Int,
        @SerializedName("thumbnail_height") val thumbnailHeight: Int,
        @SerializedName("hide_score") val hideScore: Boolean,
        @SerializedName("name") val name: String?,
        @SerializedName("quarantine") val quarantine: Boolean,
        @SerializedName("link_flair_text_color") val linkFlairTextColor: String?,
        @SerializedName("author_flair_background_color") val authorFlairBackgroundColor: Any?,
        @SerializedName("subreddit_type") val subredditType: String?,
        @SerializedName("ups") val ups: Int,
        @SerializedName("domain") val domain: String?,
        @SerializedName("media_embed") val mediaEmbed: MediaEmbed,
        @SerializedName("thumbnail_width") val thumbnailWidth: Int,
        @SerializedName("author_flair_template_id") val authorFlairTemplateId: Any?,
        @SerializedName("is_original_content") val isOriginalContent: Boolean,
        @SerializedName("user_reports") val userReports: List<Any>,
        @SerializedName("secure_media") val secureMedia: Any?,
        @SerializedName("is_reddit_media_domain") val isRedditMediaDomain: Boolean,
        @SerializedName("is_meta") val isMeta: Boolean,
        @SerializedName("category") val category: Any?,
        @SerializedName("secure_media_embed") val secureMediaEmbed: SecureMediaEmbed,
        @SerializedName("link_flair_text") val linkFlairText: Any?,
        @SerializedName("can_mod_post") val canModPost: Boolean,
        @SerializedName("score") val score: Int,
        @SerializedName("approved_by") val approvedBy: Any?,
        @SerializedName("thumbnail") val thumbnail: String?,
        @SerializedName("edited") val edited: String?,
        @SerializedName("author_flair_css_class") val authorFlairCssClass: Any?,
        @SerializedName("author_flair_richtext") val authorFlairRichtext: List<Any>,
        @SerializedName("post_hint") val postHint: String?,
        @SerializedName("content_categories") val contentCategories: Any?,
        @SerializedName("is_self") val isSelf: Boolean,
        @SerializedName("mod_note") val modNote: Any?,
        @SerializedName("created") val created: Int,
        @SerializedName("link_flair_type") val linkFlairType: String?,
        @SerializedName("wls") val wls: Int,
        @SerializedName("banned_by") val bannedBy: Any?,
        @SerializedName("author_flair_type") val authorFlairType: String?,
        @SerializedName("contest_mode") val contestMode: Boolean,
        @SerializedName("selftext_html") val selftextHtml: Any?,
        @SerializedName("likes") val likes: Any?,
        @SerializedName("suggested_sort") val suggestedSort: Any?,
        @SerializedName("banned_at_utc") val bannedAtUtc: Any?,
        @SerializedName("view_count") val viewCount: Any?,
        @SerializedName("archived") val archived: Boolean,
        @SerializedName("no_follow") val noFollow: Boolean,
        @SerializedName("is_crosspostable") val isCrosspostable: Boolean,
        @SerializedName("pinned") val pinned: Boolean,
        @SerializedName("over_18") val over18: Boolean,
        @SerializedName("preview") val preview: Preview,
        @SerializedName("media_only") val mediaOnly: Boolean,
        @SerializedName("link_flair_template_id") val linkFlairTemplateId: Any?,
        @SerializedName("can_gild") val canGild: Boolean,
        @SerializedName("spoiler") val spoiler: Boolean,
        @SerializedName("locked") val locked: Boolean,
        @SerializedName("author_flair_text") val authorFlairText: Any?,
        @SerializedName("visited") val visited: Boolean,
        @SerializedName("num_reports") val numReports: Any?,
        @SerializedName("distinguished") val distinguished: Any?,
        @SerializedName("subreddit_id") val subredditId: String?,
        @SerializedName("mod_reason_by") val modReasonBy: Any?,
        @SerializedName("removal_reason") val removalReason: Any?,
        @SerializedName("link_flair_background_color") val linkFlairBackgroundColor: String?,
        @SerializedName("id") val id: String?,
        @SerializedName("report_reasons") val reportReasons: Any?,
        @SerializedName("author") val author: String?,
        @SerializedName("num_crossposts") val numCrossposts: Int,
        @SerializedName("num_comments") val numComments: Int,
        @SerializedName("send_replies") val sendReplies: Boolean,
        @SerializedName("whitelist_status") val whitelistStatus: String?,
        @SerializedName("mod_reports") val modReports: List<Any>,
        @SerializedName("author_flair_text_color") val authorFlairTextColor: Any?,
        @SerializedName("permalink") val permalink: String?,
        @SerializedName("parent_whitelist_status") val parentWhitelistStatus: String?,
        @SerializedName("stickied") val stickied: Boolean,
        @SerializedName("url") val url: String?,
        @SerializedName("subreddit_subscribers") val subredditSubscribers: Int,
        @SerializedName("created_utc") val createdUtc: Long,
        @SerializedName("media") val media: Any?,
        @SerializedName("is_video") val isVideo: Boolean
)

data class Preview(
        @SerializedName("images") val images: List<Image>,
        @SerializedName("reddit_video_preview") val redditVideoPreview: RedditVideoPreview,
        @SerializedName("enabled") val enabled: Boolean
)

data class Image(
        @SerializedName("source") val source: Source,
        @SerializedName("resolutions") val resolutions: List<Resolution>,
        @SerializedName("variants") val variants: Variants,
        @SerializedName("id") val id: String?
)

data class RedditVideoPreview(
        @SerializedName("fallback_url") val fallbackUrl: String?,
        @SerializedName("height") val height: Int,
        @SerializedName("width") val width: Int,
        @SerializedName("scrubber_media_url") val scrubberMediaUrl: String?,
        @SerializedName("dash_url") val dashUrl: String?,
        @SerializedName("duration") val duration: Int,
        @SerializedName("hls_url") val hlsUrl: String?,
        @SerializedName("is_gif") val isGif: Boolean,
        @SerializedName("transcoding_status") val transcodingStatus: String?
)

data class MediaEmbed(
        @SerializedName("content") val content: String?,
        @SerializedName("width") val width: Int,
        @SerializedName("scrolling") val scrolling: Boolean,
        @SerializedName("height") val height: Int
)

data class SecureMediaEmbed(
        @SerializedName("content") val content: String?,
        @SerializedName("width") val width: Int,
        @SerializedName("scrolling") val scrolling: Boolean,
        @SerializedName("media_domain_url") val mediaDomainUrl: String?,
        @SerializedName("height") val height: Int
)

data class Variants(
        @SerializedName("gif") val gif: Gif,
        @SerializedName("mp4") val mp4: Mp4
)

data class Source(
        @SerializedName("url") val url: String?,
        @SerializedName("width") val width: Int,
        @SerializedName("height") val height: Int
)

data class Gif(
        @SerializedName("source") val source: Source,
        @SerializedName("resolutions") val resolutions: List<Resolution>
)

data class Resolution(
        @SerializedName("url") val url: String?,
        @SerializedName("width") val width: Int,
        @SerializedName("height") val height: Int
)

data class Mp4(
        @SerializedName("source") val source: Source,
        @SerializedName("resolutions") val resolutions: List<Resolution>
)