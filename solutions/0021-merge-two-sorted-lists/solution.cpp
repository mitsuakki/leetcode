/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* mergeTwoLists(ListNode* list1, ListNode* list2) {
        map<int, int> freq;

        // Compter les occurrences dans list1
        ListNode* current = list1;
        while (current != nullptr) {
            freq[current->val]++;
            current = current->next;
        }

        // Compter les occurrences dans list2
        current = list2;
        while (current != nullptr) {
            freq[current->val]++;
            current = current->next;
        }

        // Construire la liste résultante triée
        ListNode* result = nullptr;
        ListNode* tail = nullptr;

        for (const auto& pair : freq) {
            for (int i = 0; i < pair.second; i++) {
                ListNode* node = new ListNode(pair.first);

                if (result == nullptr) {
                    result = node;
                    tail = node;
                } else {
                    tail->next = node;
                    tail = node;
                }
            }
        }

        return result;
    }
};
