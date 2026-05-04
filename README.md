# Java-DSA-Portfolio

Core data structures and algorithms, rewritten in Java from scratch. Built each one to learn how it works. Each folder is a standalone, runnable implementation with its own `Test` driver.

![Java](https://img.shields.io/badge/Java-17+-007396?logo=java&logoColor=white)

---

## Implementations

| Topic | Summary |
|---|---|
| **[AVL Tree](https://github.com/ardaozkaranfil/Java-DSA-Portfolio/tree/main/AVL%20Tree/src)** | Self-balancing binary search tree with all four rotation cases (LL/RR/LR/RL); supports `insert`, `search`, an `isAVL` validator, and a static tree-equality comparator (`AVLEquals`). |
| **[BST](https://github.com/ardaozkaranfil/Java-DSA-Portfolio/tree/main/BST/src)** | Binary search tree with utility methods for `findMax`, `findDepth`, in-order list collection (`toInorderList`), and duplicate-detection / removal (`hasUniqueElements`, `removeDuplicates`). |
| **[Circular Doubly Linked List](https://github.com/ardaozkaranfil/Java-DSA-Portfolio/tree/main/Circular%20Doubly%20Linked%20List/src)** | Doubly linked list with head ↔ tail circular linkage and a separate `LLNode` class; supports tail append, middle-element deletion, and bidirectional positional access. |
| **[Hash Table](https://github.com/ardaozkaranfil/Java-DSA-Portfolio/tree/main/Hash%20Table/src)** | Open-addressing hash table with **quadratic probing**, dynamic **rehashing** when load factor ≥ 0.5, and automatic next-prime capacity selection. |
| **[Min Heap](https://github.com/ardaozkaranfil/Java-DSA-Portfolio/tree/main/Min%20Heap/src)** | Auto-growing array-backed min-heap with `insert`/`deleteMin`, indexed `delete`, `decreaseKey`/`increaseKey`, `mergeHeaps`, `getHeight`, and an `isMinHeap` validator. |
| **[Priority Queue](https://github.com/ardaozkaranfil/Java-DSA-Portfolio/tree/main/Priority%20Queue/src)** | Sorted linked-list priority queue of `(priority, name)` entries; supports `enqueue` (priority-ordered insertion), `dequeue`, `findPlace`, and `promote` (raise priority and reinsert). |
| **[Sorting](https://github.com/ardaozkaranfil/Java-DSA-Portfolio/tree/main/Sorting/src)** | `bubbleSort` with early-exit optimization and `heapSort` powered by a custom auto-growing `MaxHeap`. |
| **[Two Stacks in One Array](https://github.com/ardaozkaranfil/Java-DSA-Portfolio/tree/main/Two%20Stacks%20in%20One%20Array/src)** | Two stacks growing toward each other from opposite ends of a single fixed-size array; per-stack `push`/`pop`/`top`, plus `swapTops`, bulk-clear methods, and a bulk-transfer helper that moves N elements from stack one onto stack two. |

---

## Related Work

- **[Java-OOP-Portfolio](https://github.com/ardaozkaranfil/Java-OOP-Portfolio)** — Object-oriented programming exercises and design problems.
