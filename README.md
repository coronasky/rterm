# rTerm: A BBS terminal APP for Android

This version is based on the latest available code from https://github.com/DAMWID/rterm, which is rterm v1.1.2. 
It does not support PanelController and toggling function key bar.

The original author 猪头小队长 Javor@newsmth has published a v1.2.0 alpha https://m.newsmth.net/article/Android/382?p=1#a1. 
However, the code base for v1.2.0 has been lost. 

After reaching out to the original author, I decided to decompile v1.2.0's apk.
I was able to recover most part of the features in v1.2.0. 
However, I have dropped the domob ads module, which does not affect main functionalities.

I plan to keep improving and fixing bugs as needed. 
However, no further maintainance should be expected by any means. 

Feel free to fork and add whatever features you want.

## Change log:
### 1.2.0
(From original author 猪头小队长) 主要改进：
1. 增加SSH支持，处于实验阶段，可能会出现异常断线等不稳定状况，现在还不建议普通用户使用SSH方式
2. 增加可自动隐藏的控制面板，“Up”，“Down”，“Left”，“Right”，“Enter”，“PageUp”,“PageDown”,“Home”，“End”，“呼叫软键盘”，“呼叫快捷按键”均可以通过此面板完成
3. (dropped) 解放音量放大/音量缩小键，毕竟边听歌边Term还是一件比较惬意的事情。(kept) 将与之对应的呼叫快捷按键/呼叫软键盘的功能集成到控制面板中
4. 优化显示软键盘时的界面展示
5. 优化地址簿界面的展示，增加主机是否是SSH，是否自动登录等信息的展示
