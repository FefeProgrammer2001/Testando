#include <iostream>
#include <thread>
#include <mutex>
#include <condition_variable>
#include <vector>
#include <atomic>

class Node {
public:
    int data;
    Node* left;
    Node* right;

    Node(int value) {
        data = value;
        left = nullptr;
        right = nullptr;
    }
};

class BinaryTree {
private:
    Node* root;
    std::mutex mtx;
    std::condition_variable cv;
    std::vector<std::thread> threads;
    std::atomic<int> counter;

public:
    BinaryTree() {
        root = nullptr;
        counter = 0;
    }

    void createTree() {
        for(int i = 1; i <= 127; i++) {
            std::thread t(&BinaryTree::insertNode, this, i);
            threads.push_back(std::move(t));
        }

        for(auto& t : threads) {
            t.join();
        }
    }

    void insertNode(int value) {
        std::unique_lock<std::mutex> lock(mtx);
        cv.wait(lock, [this] { return counter < 127; });
        insertNodeRecursive(root, value);
        counter++;
        cv.notify_one();
    }

    void insertNodeRecursive(Node*& node, int value) {
        if(node == nullptr) {
            node = new Node(value);
            return;
        }
        if(value < node->data) {
            insertNodeRecursive(node->left, value);
        } else {
            insertNodeRecursive(node->right, value);
        }
    }

    void printTree() {
        printTreeRecursive(root, 0);
    }

private:
    void printTreeRecursive(Node* node, int level) {
        if(node == nullptr) {
            return;
        }

        printTreeRecursive(node->right, level + 1);

        for(int i = 0; i < level; i++) {
            std::cout << "    ";
        }
        std::cout << node->data << std::endl;

        printTreeRecursive(node->left, level + 1);
    }
};

int main() {
    BinaryTree tree;
    tree.createTree();
    tree.printTree();
    return 0;
}
