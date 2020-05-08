package rettrofit;

public interface RequestListener<T> {
    void onSuccess(T response);
    void onError(Throwable t);
}
