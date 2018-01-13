package br.com.renanbarbieri.bemobichallenge.presentation.liveData.model

/**
 * Created by renan on 13/01/18.
 */
class ErrorLiveData(val message: String, val errorCode: ErrorCode) {
    class ErrorCode {
        val code: Int

        companion object {
            const val ERROR_CODE_UNKNOWN = 100
            const val ERROR_CODE_HTTP = 400

            const val ERROR_STRING_UNKNOWN = "ERROR_UNKNOWN"
        }

        constructor(code: Int) {
            when (code) {
                ERROR_CODE_HTTP -> {
                    this.code = code
                }
                ERROR_CODE_UNKNOWN -> {
                    this.code = code
                }
                else -> {
                    this.code = code
                }
            }
        }

        constructor(code: String) {
            when (code) {
                ERROR_STRING_UNKNOWN -> {
                    this.code = ERROR_CODE_UNKNOWN
                }
                else -> {
                    this.code = ERROR_CODE_UNKNOWN
                }
            }
        }
    }
}