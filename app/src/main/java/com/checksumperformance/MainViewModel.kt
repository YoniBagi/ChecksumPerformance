package com.checksumperformance

import android.app.Application
import android.content.Context
import android.media.AudioManager
import android.media.AudioManager.GET_DEVICES_ALL
import android.media.AudioManager.STREAM_ACCESSIBILITY
import android.media.AudioManager.STREAM_ALARM
import android.media.AudioManager.STREAM_DTMF
import android.media.AudioManager.STREAM_MUSIC
import android.media.AudioManager.STREAM_NOTIFICATION
import android.media.AudioManager.STREAM_RING
import android.media.AudioManager.STREAM_SYSTEM
import android.media.AudioManager.STREAM_VOICE_CALL
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.AndroidViewModel

class MainViewModel(private val mApp: Application): AndroidViewModel(mApp) {
    private val mAudioManager: AudioManager = mApp.getSystemService(Context.AUDIO_SERVICE) as AudioManager

    @RequiresApi(Build.VERSION_CODES.S)
    fun onStartClicked() {
        Log.d("AudioManagerTest", "started")
        val ringerMode = mAudioManager.ringerMode
        Log.d("AudioManagerTest", "ringerMode: $ringerMode")
        val mode = mAudioManager.mode
        Log.d("AudioManagerTest", "Mode: $mode")

        getMaxVolumeByType()
        getStreamVolume()
        getMinVolume()

        val devices = mAudioManager.getDevices(AudioManager.GET_DEVICES_INPUTS)
        Log.d("AudioManagerTest", "Devices: ${devices.joinToString { ", " }}")

        val devicesCommunication = mAudioManager.communicationDevice
        Log.d("AudioManagerTest", "devicesCommunication: $devicesCommunication devicesCommunication?.type: ${devicesCommunication?.type}")

        Log.d("AudioManagerTest", "mAudioManager.isMusicActive: ${mAudioManager.isMusicActive}")
        Log.d("AudioManagerTest", "mAudioManager.isMicrophoneMute ${mAudioManager.isMicrophoneMute}")

    }
    @RequiresApi(Build.VERSION_CODES.P)
    private fun getMinVolume() {
        val volumeVoiceCall = mAudioManager.getStreamMinVolume(STREAM_VOICE_CALL)
        Log.d("AudioManagerTest", "StreamMinVolumeVoiceCall_STREAM_VOICE_CALL: $volumeVoiceCall")

        val volumeSystem = mAudioManager.getStreamMinVolume(STREAM_SYSTEM)
        Log.d("AudioManagerTest", "StreamMinVolumeSystem_STREAM_SYSTEM: $volumeSystem")

        val volumeRing = mAudioManager.getStreamMinVolume(STREAM_RING)
        Log.d("AudioManagerTest", "StreamMinVolumeRing_STREAM_RING: $volumeRing")

        val volumeMusic = mAudioManager.getStreamMinVolume(STREAM_MUSIC)
        Log.d("AudioManagerTest", "StreamMinVolumeMusic_STREAM_MUSIC: $volumeMusic")

        val volumeAlarm = mAudioManager.getStreamMinVolume(STREAM_ALARM)
        Log.d("AudioManagerTest", "StreamMinVolumeAlarm_STREAM_ALARM: $volumeAlarm")

        val volumeNotification = mAudioManager.getStreamMinVolume(STREAM_NOTIFICATION)
        Log.d("AudioManagerTest", "StreamMinVolumeNotification_STREAM_NOTIFICATION: $volumeNotification")

        val volumeDtmf = mAudioManager.getStreamMinVolume(STREAM_DTMF)
        Log.d("AudioManagerTest", "StreamMinVolumeDtmf_STREAM_DTMF: $volumeDtmf")

        val volumeAccessibility = mAudioManager.getStreamMinVolume(STREAM_ACCESSIBILITY)
        Log.d("AudioManagerTest", "StreamMinVolumeAccessibility_STREAM_ACCESSIBILITY: $volumeAccessibility")
    }

    private fun getStreamVolume() {
        val volumeVoiceCall = mAudioManager.getStreamVolume(STREAM_VOICE_CALL)
        Log.d("AudioManagerTest", "volumeVoiceCall_STREAM_VOICE_CALL: $volumeVoiceCall")

        val volumeSystem = mAudioManager.getStreamVolume(STREAM_SYSTEM)
        Log.d("AudioManagerTest", "volumeSystem_STREAM_SYSTEM: $volumeSystem")

        val volumeRing = mAudioManager.getStreamVolume(STREAM_RING)
        Log.d("AudioManagerTest", "volumeRing_STREAM_RING: $volumeRing")

        val volumeMusic = mAudioManager.getStreamVolume(STREAM_MUSIC)
        Log.d("AudioManagerTest", "volumeMusic_STREAM_MUSIC: $volumeMusic")

        val volumeAlarm = mAudioManager.getStreamVolume(STREAM_ALARM)
        Log.d("AudioManagerTest", "volumeAlarm_STREAM_ALARM: $volumeAlarm")

        val volumeNotification = mAudioManager.getStreamVolume(STREAM_NOTIFICATION)
        Log.d("AudioManagerTest", "volumeNotification_STREAM_NOTIFICATION: $volumeNotification")

        val volumeDtmf = mAudioManager.getStreamVolume(STREAM_DTMF)
        Log.d("AudioManagerTest", "volumeDtmf_STREAM_DTMF: $volumeDtmf")

        val volumeAccessibility = mAudioManager.getStreamVolume(STREAM_ACCESSIBILITY)
        Log.d("AudioManagerTest", "volumeAccessibility_STREAM_ACCESSIBILITY: $volumeAccessibility")
    }

    private fun getMaxVolumeByType() {
        val maxVolumeStreamVoiceCall = mAudioManager.getStreamMaxVolume(STREAM_VOICE_CALL)
        Log.d("AudioManagerTest", "StreamMaxVolume_STREAM_VOICE_CALL: $maxVolumeStreamVoiceCall")

        val maxVolumeStreamSystem = mAudioManager.getStreamMaxVolume(STREAM_SYSTEM)
        Log.d("AudioManagerTest", "StreamMaxVolume_STREAM_SYSTEM: $maxVolumeStreamSystem")

        val maxVolumeStreamRing = mAudioManager.getStreamMaxVolume(STREAM_RING)
        Log.d("AudioManagerTest", "StreamMaxVolume_STREAM_RING: $maxVolumeStreamRing")

        val maxVolumeStreamMusic = mAudioManager.getStreamMaxVolume(STREAM_MUSIC)
        Log.d("AudioManagerTest", "StreamMaxVolume_STREAM_MUSIC: $maxVolumeStreamMusic")

        val maxVolumeStreamAlarm = mAudioManager.getStreamMaxVolume(STREAM_ALARM)
        Log.d("AudioManagerTest", "StreamMaxVolume_STREAM_ALARM: $maxVolumeStreamAlarm")

        val maxVolumeStreamNotification = mAudioManager.getStreamMaxVolume(STREAM_NOTIFICATION)
        Log.d("AudioManagerTest", "StreamMaxVolume_STREAM_NOTIFICATION: $maxVolumeStreamNotification")

        val maxVolumeStreamDtmf = mAudioManager.getStreamMaxVolume(STREAM_DTMF)
        Log.d("AudioManagerTest", "StreamMaxVolume_STREAM_DTMF: $maxVolumeStreamDtmf")

        val maxVolumeStreamAccessibility = mAudioManager.getStreamMaxVolume(STREAM_ACCESSIBILITY)
        Log.d("AudioManagerTest", "StreamMaxVolume_STREAM_ACCESSIBILITY: $maxVolumeStreamAccessibility")
    }

    fun onStopClicked(){

    }
}