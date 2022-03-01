package com.company;

import java.util.Scanner;

public class Login {
    public Login() {
        printWelcome();
        login();
    }

    public static void printWelcome() {
        int i, len;
        String name= "WELCOME";
        len = name.length();
        name = name.toUpperCase();
        System.out.println();
        for (i = 0; i < len; i++) {
            if (name.charAt(i) == 'A' || name.charAt(i) == 'B' || name.charAt(i) == 'C' || name.charAt(i) == 'E' || name.charAt(i) == 'F' || name.charAt(i) == 'G' || name.charAt(i) == 'I' || name.charAt(i) == 'J' || name.charAt(i) == 'O' || name.charAt(i) == 'P' || name.charAt(i) == 'Q' || name.charAt(i) == 'R' || name.charAt(i) == 'S' || name.charAt(i) == 'T' || name.charAt(i) == 'Z') {
                System.out.print("\t\t   *****");
            } else if (name.charAt(i) == 'H' || name.charAt(i) == 'K' || name.charAt(i) == 'M' || name.charAt(i) == 'N' || name.charAt(i) == 'U' || name.charAt(i) == 'V' || name.charAt(i) == 'W' || name.charAt(i) == 'X' || name.charAt(i) == 'Y') {
                System.out.print("\t\t   *   *");
            } else if (name.charAt(i) == 'D') {
                System.out.print("\t\t       *");
            } else if (name.charAt(i) == 'L') {
                System.out.print("\t\t   *    ");
            }
        }
        System.out.print("\n");
        for (i = 0; i < len; i++) {
            if (name.charAt(i) == 'A' || name.charAt(i) == 'B' || name.charAt(i) == 'G' || name.charAt(i) == 'H' || name.charAt(i) == 'O' || name.charAt(i) == 'P' || name.charAt(i) == 'Q' || name.charAt(i) == 'R' || name.charAt(i) == 'U' || name.charAt(i) == 'V' || name.charAt(i) == 'W') {
                System.out.print("\t\t   *   *");
            } else if (name.charAt(i) == 'C' || name.charAt(i) == 'E' || name.charAt(i) == 'F' || name.charAt(i) == 'L' || name.charAt(i) == 'S') {
                System.out.print("\t\t   *    ");
            }
            if (name.charAt(i) == 'M') {
                System.out.print("\t\t   ** **");
            } else if (name.charAt(i) == 'Y') {
                System.out.print("\t\t    * * ");
            } else if (name.charAt(i) == 'K') {
                System.out.print("\t\t   *  * ");
            } else if (name.charAt(i) == 'I' || name.charAt(i) == 'J' || name.charAt(i) == 'T') {
                System.out.print("\t\t     *  ");
            } else if (name.charAt(i) == 'D') {
                System.out.print("\t\t       *");
            } else if (name.charAt(i) == 'N') {
                System.out.print("\t\t   **  *");
            } else if (name.charAt(i) == 'Z') {
                System.out.print("\t\t      * ");
            } else if (name.charAt(i) == 'X') {
                System.out.print("\t\t        ");
            }
        }
        System.out.print("\n");
        for (i = 0; i < len; i++) {
            if (name.charAt(i) == 'A' || name.charAt(i) == 'B' || name.charAt(i) == 'G' || name.charAt(i) == 'H' || name.charAt(i) == 'N' || name.charAt(i) == 'O' || name.charAt(i) == 'P' || name.charAt(i) == 'Q' || name.charAt(i) == 'R' || name.charAt(i) == 'U' || name.charAt(i) == 'V' || name.charAt(i) == 'W') {
                System.out.print("\t\t   *   *");
            } else if (name.charAt(i) == 'C' || name.charAt(i) == 'E' || name.charAt(i) == 'F' || name.charAt(i) == 'L' || name.charAt(i) == 'S') {
                System.out.print("\t\t   *    ");
            }
            if (name.charAt(i) == 'M') {
                System.out.print("\t\t   * * *");
            } else if (name.charAt(i) == 'Y') {
                System.out.print("\t\t     *  ");
            } else if (name.charAt(i) == 'K') {
                System.out.print("\t\t   * *  ");
            } else if (name.charAt(i) == 'I' || name.charAt(i) == 'J' || name.charAt(i) == 'T') {
                System.out.print("\t\t     *  ");
            } else if (name.charAt(i) == 'D') {
                System.out.print("\t\t       *");
            } else if (name.charAt(i) == 'X') {
                System.out.print("\t\t    * * ");
            } else if (name.charAt(i) == 'Z') {
                System.out.print("\t\t        ");
            }
        }
        System.out.print("\n");
        for (i = 0; i < len; i++) {
            if (name.charAt(i) == 'A' || name.charAt(i) == 'B' || name.charAt(i) == 'D' || name.charAt(i) == 'E' || name.charAt(i) == 'F' || name.charAt(i) == 'G' || name.charAt(i) == 'H' || name.charAt(i) == 'P' || name.charAt(i) == 'Q' || name.charAt(i) == 'R' || name.charAt(i) == 'S') {
                System.out.print("\t\t   *****");
            } else if (name.charAt(i) == 'C') {
                System.out.print("\t\t   *    ");
            }
            if (name.charAt(i) == 'M' || name.charAt(i) == 'O' || name.charAt(i) == 'V' || name.charAt(i) == 'W' || name.charAt(i) == 'U') {
                System.out.print("\t\t   *   *");
            } else if (name.charAt(i) == 'Z') {
                System.out.print("\t\t     *  ");
            } else if (name.charAt(i) == 'K') {
                System.out.print("\t\t   **   ");
            } else if (name.charAt(i) == 'I' || name.charAt(i) == 'J' || name.charAt(i) == 'T' || name.charAt(i) == 'Y') {
                System.out.print("\t\t     *  ");
            } else if (name.charAt(i) == 'L') {
                System.out.print("\t\t   *    ");
            } else if (name.charAt(i) == 'N') {
                System.out.print("\t\t   * * *");
            } else if (name.charAt(i) == 'X') {
                System.out.print("\t\t     *  ");
            }
        }
        System.out.print("\n");
        for (i = 0; i < len; i++) {
            if (name.charAt(i) == 'A' || name.charAt(i) == 'B' || name.charAt(i) == 'D' || name.charAt(i) == 'H' || name.charAt(i) == 'M' || name.charAt(i) == 'N' || name.charAt(i) == 'O' || name.charAt(i) == 'U' || name.charAt(i) == 'V') {
                System.out.print("\t\t   *   *");
            } else if (name.charAt(i) == 'C' || name.charAt(i) == 'E' || name.charAt(i) == 'F' || name.charAt(i) == 'L' || name.charAt(i) == 'P') {
                System.out.print("\t\t   *    ");
            }
            if (name.charAt(i) == 'G' || name.charAt(i) == 'Q' || name.charAt(i) == 'S') {
                System.out.print("\t\t       *");
            } else if (name.charAt(i) == 'K') {
                System.out.print("\t\t   * *  ");
            } else if (name.charAt(i) == 'I' || name.charAt(i) == 'J' || name.charAt(i) == 'T' || name.charAt(i) == 'Y') {
                System.out.print("\t\t     *  ");
            } else if (name.charAt(i) == 'R') {
                System.out.print("\t\t   * *  ");
            } else if (name.charAt(i) == 'W') {
                System.out.print("\t\t   * * *");
            } else if (name.charAt(i) == 'X') {
                System.out.print("\t\t    * * ");
            } else if (name.charAt(i) == 'Z') {
                System.out.print("\t\t        ");
            }
        }
        System.out.print("\n");
        for (i = 0; i < len; i++) {
            if (name.charAt(i) == 'A' || name.charAt(i) == 'B' || name.charAt(i) == 'D' || name.charAt(i) == 'H' || name.charAt(i) == 'M' || name.charAt(i) == 'O' || name.charAt(i) == 'U' || name.charAt(i) == 'V') {
                System.out.print("\t\t   *   *");
            } else if (name.charAt(i) == 'C' || name.charAt(i) == 'E' || name.charAt(i) == 'F' || name.charAt(i) == 'L' || name.charAt(i) == 'P') {
                System.out.print("\t\t   *    ");
            }
            if (name.charAt(i) == 'G' || name.charAt(i) == 'Q' || name.charAt(i) == 'S') {
                System.out.print("\t\t       *");
            } else if (name.charAt(i) == 'K') {
                System.out.print("\t\t   *  * ");
            } else if (name.charAt(i) == 'I' || name.charAt(i) == 'T' || name.charAt(i) == 'Y') {
                System.out.print("\t\t     *  ");
            } else if (name.charAt(i) == 'R') {
                System.out.print("\t\t   *  * ");
            } else if (name.charAt(i) == 'W') {
                System.out.print("\t\t   ** **");
            } else if (name.charAt(i) == 'J') {
                System.out.print("\t\t   * *  ");
            } else if (name.charAt(i) == 'N') {
                System.out.print("\t\t   *  **");
            } else if (name.charAt(i) == 'Z') {
                System.out.print("\t\t    *    ");
            } else if (name.charAt(i) == 'X') {
                System.out.print("\t\t        ");
            }
        }
        System.out.print("\n");
        for (i = 0; i < len; i++) {
            if (name.charAt(i) == 'B' || name.charAt(i) == 'C' || name.charAt(i) == 'D' || name.charAt(i) == 'E' || name.charAt(i) == 'G' || name.charAt(i) == 'I' || name.charAt(i) == 'O' || name.charAt(i) == 'L' || name.charAt(i) == 'S' || name.charAt(i) == 'U' || name.charAt(i) == 'Z') {
                System.out.print("\t\t   *****");
            } else if (name.charAt(i) == 'A' || name.charAt(i) == 'H' || name.charAt(i) == 'M' || name.charAt(i) == 'N') {
                System.out.print("\t\t   *   *");
            }
            if (name.charAt(i) == 'F' || name.charAt(i) == 'P') {
                System.out.print("\t\t   *    ");
            } else if (name.charAt(i) == 'J') {
                System.out.print("\t\t   ***  ");
            } else if (name.charAt(i) == 'K' || name.charAt(i) == 'R') {
                System.out.print("\t\t   *   *");
            } else if (name.charAt(i) == 'Q') {
                System.out.print("\t\t       *");
            } else if (name.charAt(i) == 'T' || name.charAt(i) == 'V' || name.charAt(i) == 'Y') {
                System.out.print("\t\t     *  ");
            } else if (name.charAt(i) == 'W' || name.charAt(i) == 'X') {
                System.out.print("\t\t   *   *");
            }
        }
        System.out.println("\n");
    }

    public static void login() {
        String username = "HelloWorld";
        String password = "123";
        boolean isGranted = false;

        System.out.println("Please login to continue.");
        for (int i = 1; i <= 3; i++) {
            Scanner input1 = new Scanner(System.in);
            System.out.print(String.format("%50s", "=").replace(' ', '=') + "\n");
            System.out.print("Enter Username : ");
            String usernameInput = input1.nextLine();

            System.out.print("Enter Password : ");
            String passwordInput = input1.nextLine();
            System.out.print(String.format("%50s", "=").replace(' ', '=') + "\n");

            if (usernameInput.compareTo(username)==0 && passwordInput.compareTo(password)==0)
                isGranted = true;

            if (usernameInput.compareTo(username) != 0)
                System.out.println("Invalid Username!");

            if (passwordInput.compareTo(password) != 0)
                System.out.println("Invalid Password!");

            System.out.println();

            if (!isGranted) {
                if (i == 3) {
                    System.out.println("* Access Denied! You have reached the maximum number of attempts. *");
                    System.exit(0);
                }else{
                    System.out.print("* YOU ONLY HAVE " + (3 - i) + " ATTEMPT");
                    if ((3 - i) > 1)
                        System.out.println("S LEFT! *");
                    else
                        System.out.println(" LEFT! *");
                }
            } else {
                System.out.println("Access granted, you have successfully logged in.");
                break;
            }
        }
    }
}
