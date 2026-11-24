
## Server binding expectations (not tested)

The configured port is `8081`, so the API is expected at `http://<host>:8081`.

| `server.address` | Result |
|---|---|
| `127.0.0.1` | `http://127.0.0.1:8081` works locally. `localhost` also works. | 
| `localhost` | `http://localhost:8081` works locally. A colleague cannot reach it. |
| `<private-ip>` | `http://<private-ip>:8081` works locally. `localhost` does not to work. A colleague on the same Wi-Fi may reach it if the firewall allows the connection. | 
| `0.0.0.0` | `localhost`, `127.0.0.1`, and the private IP all work. A colleague on the same Wi-Fi may reach `http://<private-ip>:8081/feedback` if the firewall and network allow it. |

`0.0.0.0` is the recommended final value when colleagues need network access. The colleague test must be done from another device; these are expected results, not observed test results.
