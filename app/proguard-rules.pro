# Add project specific ProGuard rules here.
-keep class com.unitv.launcher.** { *; }
-keepattributes *Annotation*
-keepattributes SourceFile,LineNumberTable
-dontwarn androidx.**
-keep class androidx.** { *; }
