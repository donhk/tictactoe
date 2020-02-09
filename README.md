# tictactoe
tic-tac-toe algorithm for N rows

- It should find if there is a Winner horizontally
- It should find if there is a Winner vertically
- It should find if there is a Winner or in diagonal
- The input is a String that represents the board as x|o|. everything ese is taken as '.'
- The input is case insensitive
- it should be as fast as possible

Run the tests using these options

    -ea -Xmx10000m

#### Serial execution
    Preparing board of 25000 rows
    Board prepared in [23]
    Board evaluated summary | rows [25000] cells [625000000] seconds [4]
    Preparing board of 25000 rows
    Board prepared in [12]
    Board evaluated summary | rows [25000] cells [625000000] seconds [4]
    Preparing board of 25000 rows
    Board prepared in [25]
    Board evaluated summary | rows [25000] cells [625000000] seconds [3]
    Preparing board of 25000 rows
    Board prepared in [9]
    Board evaluated summary | rows [25000] cells [625000000] seconds [4]
    BUILD SUCCESSFUL in 1m 30s
    
#### Parallel execution

    Preparing board of 25000 rows
    Board prepared in [22]
    Board evaluated summary | rows [25000] cells [625000000] seconds [4]
    Preparing board of 25000 rows
    Board prepared in [24]
    Board evaluated summary | rows [25000] cells [625000000] seconds [4]
    Preparing board of 25000 rows
    Board prepared in [9]
    Board evaluated summary | rows [25000] cells [625000000] seconds [4]
    Preparing board of 25000 rows
    Board prepared in [11]
    Board evaluated summary | rows [25000] cells [625000000] seconds [4]
    BUILD SUCCESSFUL in 1m 27s
    
#### TODO's

*Add support for Millions of rows using cache in disk