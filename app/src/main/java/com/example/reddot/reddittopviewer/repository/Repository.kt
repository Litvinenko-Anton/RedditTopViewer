package com.example.reddot.reddittopviewer.repository

import com.example.reddot.reddittopviewer.repository.locale.LocaleRepository
import com.example.reddot.reddittopviewer.repository.remote.RemoteRepository
import com.example.reddot.reddittopviewer.repository.remote.api.pojo.Top

interface Repository : RemoteRepository, LocaleRepository<Top>