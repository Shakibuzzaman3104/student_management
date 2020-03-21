//
// Created by Shakibuzzaman on 11/22/2019.
//
#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring

JNICALL
Java_com_techtrixbd_studentattendence_retrofit_ApiClient_getNativeKey(JNIEnv *env, jclass object) {
    std::string hello = "aHR0cHM6Ly9zdHVkZW50LnRlY2h0cml4YmQuY29tL2FwaS8=";
    return env->NewStringUTF(hello.c_str());
}



