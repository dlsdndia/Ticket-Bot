package hwang.macro.model

data class SiteInfo(
    val siteName: String,          // 사이트 이름 (예: "예매사이트 A")
    val siteUrl: String,           // 사이트 URL
    val loginInfo: LoginInfo       // 사이트에 대한 로그인 정보
)
