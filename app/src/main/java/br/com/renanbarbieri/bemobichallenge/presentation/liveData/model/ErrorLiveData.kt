package br.com.renanbarbieri.bemobichallenge.presentation.liveData.model

/**
 * Created by renan on 13/01/18.
 */
class ErrorLiveData(val messageRes: Int, val errorCode: ErrorCode) {
    class ErrorCode {
        val code: Int

        companion object {
            const val ERROR_CODE_UNKNOWN = 100
            const val ERROR_CODE_HTTP = 400
            const val ERROR_CODE_HTTP_NO_RESPONSE = 404
            const val ERROR_CODE_BODY_NULL = 4001

            const val ERROR_STRING_UNKNOWN = "ERROR_UNKNOWN"
        }

        constructor(code: Int) {
            this.code = code
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