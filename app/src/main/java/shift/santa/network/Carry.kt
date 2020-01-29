package shift.santa.network

interface Carry<T> {

    fun onSuccess(result: T)

    fun onFailure(throwable: Throwable)

}
