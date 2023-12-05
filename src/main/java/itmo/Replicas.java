package itmo;

public enum Replicas {
    THINK_PAST("считал");




    private String replica;

    private Replicas(String s) {
        this.replica = s;
    }

    @Override
    public String toString() {
        return this.replica;
    }
}
