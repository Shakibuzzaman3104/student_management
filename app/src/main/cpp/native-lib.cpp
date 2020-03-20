//
// Created by Shakibuzzaman on 11/22/2019.
//
#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring

JNICALL
Java_com_techtrixbd_studentattendence_retrofit_ApiClient_getNativeKey(JNIEnv *env, jclass object) {
    std::string hello = "aHR0cHM6Ly9lbmZvbWUuaW5mby9lbmZvbWUvYXBpLw==";
    return env->NewStringUTF(hello.c_str());
}



