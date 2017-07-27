
BufferedReader vs Scanner 
-------------------------

1. BufferedReader is faster than Scanner. How? BufferedReader has larger buffer than that of Scanner
2. Nothing comes for free. Sometimes(https://www.codechef.com/problems/CHOPRT), you get Runtime Exception with BufferedReader. Why? As it uses bigger buffer it may run out of Main memory(RAM).
3. If you want you can reduce the size of the buffer in BufferedReader by passing new buffer size as second argument while initializing it.