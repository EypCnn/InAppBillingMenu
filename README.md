# InAppBillingMenu

### Bu Makale Uygulamalarınıza Ekleyebileceğiniz Uygulama İçi Satın Alma İşlemini Kolaylaştıracak Makaledir. Yapmanız Gerekenleri Sırasıyla Aşağıya Yazdım Ordan Başlayabilirsiniz Ya Da Dosyayı İndirip Test Edebilirsiniz.

`AndroidManifest` İçine Eklenecek Olan
```java
<uses-permission android:name="com.android.vending.BILLING" />
<uses-permission android:name="android.permission.INTERNET" />
```

`AppBuildGradle` İçine Eklenecek Olan
```java
implementation 'com.android.support:cardview-v7:28.0.0-alpha3'
implementation 'com.android.support:design:28.0.0-alpha3'
implementation 'com.anjlab.android.iab.v3:library:1.0.44'
implementation 'com.github.javiersantos:PiracyChecker:1.2.3'
```

`BuildGradle` İçine Eklenecek Olan
```java
maven {url "https://jitpack.io"}
```

### Yukarda Bulunan Eklemeleri Yaptıkdan Sonra Projenizi Senkronizasyon Yapınız Ve Aşağıdaki Adımları Uygulamaya Devam Ediniz.

`Required` İçinde Olan res Klasörüne Giriniz Ve `drawable` İçinde Bulunan Dosyaları Kendi Uygulamanıza Ekleyiniz.
```xml
buttermilk.xml
cardview1.xml
cardview2.xml
cardview3.xml
coffee.xml
cookie.xml
dietcola.xml
donate.xml
fastfoot.xml
gift.xml
githublogo.xml
googleplus.xml
instagram.xml
popcorn.xml
share.xml
star.xml
translate.xml
twitter.xml
```

`Required` İçinde Olan res Klasörüne Giriniz Ve `layout` İçinde Bulunan `activity_donation.xml` Dosyasını Kendi Uygulamanıza Ekleyiniz.


`values/colors.xml` İçine Eklenecek Olan
```java
<color name="black">#000</color>
<color name="primary_text_color">@color/white</color>
<color name="white">#FFFFFF</color>
<color name="white_50_percent_transparency">#80FFFFFF</color>
<color name="gray">#68768A</color>
<color name="darkgray">#515C6B</color>
```

`values/dimens.xml` İçine Eklenecek Olan
```java
<resources>
    <dimen name="md_listitem_height">15dp</dimen>
</resources>
```

`values/strings.xml` İçine Eklenecek Olan
```java
    <string name="app_name">Uygulama İçi Satın Alma</string>

    <string name="github">GitHub</string>
    <string name="githubdes">Fork the project in github.</string>
    <string name="googleplus">Google Plus</string>
    <string name="googleplusdes">Join the Google plus community.</string>
    <string name="translate">Translate</string>
    <string name="translatedes">Help translating EypCnApp to your native language.</string>
    <string name="rate">Rate app</string>
    <string name="ratedes">Love this app let us know in Google play store to provide better experience</string>
    <string name="share">Share</string>

    <string name="support_development">Support Development</string>
    <string name="support_development_summary">If you enjoy using EypCnnApp consider donation as support to my work.</string>

    <string name="social">Social</string>
    <string name="instagram_page">Instagram</string>
    <string name="instagram_page_summary">Share your EypCnnApp setup to show case in instagram</string>

    <string name="twitter_page">Twitter Page</string>
    <string name="twitter_page_summary">Share your design with EypCnnApp</string>

    <string name="githublink">https://github.com/EypCnn</string>
    <string name="googlepluslink">https://plus.google.com/discover</string>
    <string name="translatelink">https://www.oneskyapp.com</string>
    <string name="appratelink">https://play.google.com/store/apps/dev?id=7415576443690303724</string>
    <string name="instagramlink">http://instagram.com/_u/eypcnnx</string>
    <string name="twitterlink">https://twitter.com/EypCnnx</string>

    <string name="cookie">Cookie</string>
    <string name="dietcola">Diet Cola</string>
    <string name="coffee">Coffee</string>
    <string name="buttermilk">Buttermilk</string>
    <string name="fastfoot">Fastfood</string>
    <string name="popcorn">Popcorn</string>
    <string name="gift">Gift</string>
```

`values/styles.xml` İçine Eklenecek Olan
```java
<resources>
    <!-- Base application theme. -->
    <style name="AppTheme" parent="Base.Theme.AppCompat.Light.DarkActionBar">
        <!-- Customize your theme here. -->
        <item name="colorPrimary">@color/colorPrimary</item>
        <item name="colorPrimaryDark">@color/colorPrimaryDark</item>
        <item name="colorAccent">@color/colorAccent</item>
        <item name="actionBarStyle">@style/MyActionBar</item>
    </style>
    <style name="MyActionBar" parent="@style/Widget.AppCompat.ActionBar.Solid">
        <item name="titleTextStyle">@style/MyTitleTextStyle</item>
    </style>
    <style name="MyTitleTextStyle" parent="@style/TextAppearance.AppCompat.Widget.ActionBar.Title">
        <item name="android:textColor">@color/black</item>
    </style>
</resources>
```

### res Klasöründe İşiniz Bitti Artık Java Bölümüne Geçiyoruz.

`Java` Klsörü İçinde Olan `Donation.java Ve AppData.java` Dosyalarını Uygulamanıza Ekleyiniz.

#### Bu İşlemden Sonra AppData.java Dosyasına Giriş Yapınız Ve Gerekli Yerleri Düzenleyiniz.

```xml
    String GOOGLE_BILLING_KEY = "UYGULAMA_LISANS_ANAHTARI";

    Ve Aşağıda Bulunan Paket Adlarını Kendinize Göre Düzenleyin Ve O Şekilde Play Console Uygulamasında Ekleme Yapınız.

    String BUY_COOKIE = "com.eypcnn.satinalma.cookie";
    String BUY_DIETCOLA = "com.eypcnn.satinalma.dietcola";
    String BUY_COFFEE = "com.eypcnn.satinalma.coffee";
    String BUY_BUTTERMILK = "com.eypcnn.satinalma.buttermilk";
    String BUY_FASTFOOD = "com.eypcnn.satinalma.fastfood";
    String BUY_POPCORN = "com.eypcnn.satinalma.popcorn";
    String BUY_GIFT = "com.eypcnn.satinalma.gift";
```


### Bu İşlemleri Sırasıyla Yaptıkdan Sonra Donation.java Klasörüne Bağlantı Verip Nerden Girilecek İse Giriş Yapmasını Sağlayın. Gerisinde İşlemimiz Bu Kadar. 

