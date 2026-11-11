# Performance tests

Load tests using [resonate](https://github.com/jecklgamis/resonate).

```sh
brew install jecklgamis/tap/resonate
```

## Root endpoint (`GET /`)

Start the app, then run:

```sh
make run                                   # or: java -jar target/spring-boot-scala-example.jar
./run-perf-tests.sh
```

Ramps to 100 req/s with 50 workers, holds for 1 minute, then ramps down. It fails
(non-zero exit) if success rate is below 99% or p95 latency exceeds 200ms.
Change `http.base_url` in the scenario to target another host.
