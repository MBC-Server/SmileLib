# SmileLib
[![](https://jitpack.io/v/smile-minecraft/SmileLib.svg)](https://jitpack.io/#smile-minecraft/SmileLib)

---
### 具體功能

規劃中的插件庫，預計涵蓋常用數學算法與插件基礎操作，
簡化製作插件的流程與維護性
未來規劃將此library上傳雲端

規劃中的功能：

1. 常用數學算法，排序、資料結構、深度及廣度優先搜尋
2. Database方法，操作MySQL與SQLite
3. Yaml操作方法，用於Config
4. REST API方法
5. Vault經濟集成
6. Placeholder API集成
7. Adventurr API集成
8. Protocolib API
9. GriefPrevention API集成
10. Bukkit Runnable 定時排程
11. Threads 多線程

### 如何引入API
Maven: 
```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```
```xml
<dependency>
    <groupId>com.github.smile-minecraft</groupId>
    <artifactId>SmileLib</artifactId>
    <version>1.2.0</version>
</dependency>
```

Gradle:
```gradle
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```
```gradle
dependencies {
    implementation 'com.github.smile-minecraft:SmileLib:1.2.0'
}
```
