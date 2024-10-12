package com.example.insert

import android.app.Application
import androidx.lifecycle.ViewModel
import com.example.database.Note
import com.example.repository.NoteRepository

// penghubung antara Activity dengan Repository
class NoteAddUpdateViewModel(application: Application): ViewModel() {

    private val mNoteRepository: NoteRepository = NoteRepository(application)

    fun insert(note: Note){
        mNoteRepository.insert(note)
    }

    fun update(note: Note) {
        mNoteRepository.update(note)
    }

    fun delete(note: Note) {
        mNoteRepository.delete(note)
    }
}