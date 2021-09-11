/**
 * we had a single temporary four note and we split it up into a two, two note
 * not connected to a four note. And then, so that's the case when it's smaller.
 * Now, we have to look at the third case, which is, when it's, the new node
 * inserted this in between and comes out of this link here. Again, we just had
 * a red link and now we have a BST with two red links along the path connected
 * to A and that's not allowed. In this case it's a bit trickier to affix the
 * situation, what we do is we rotate the bottom link left. So, and that gives
 * us this and reduce it to the other situation that we had before. And then we
 * rotate the top link right and then, we flip the colors. So, this one we used
 * all three of our operations, rotate left rotate right and flip the colors.
 * And that gets us an insertion into a tree that has from a tree that i s a
 * single three node to a tree that is three two nodes that is containing three
 * keys. So that sort of operation is going to work in a big tree when we insert
 * into a new three node at the bottom. We do the standard BST insert, color the
 * new link red, and we do the rotations that we need, either one or two
 * rotations to balance the temporary four node, and then we flip colors to pass
 * the red link up one level and then remind me to rotate to that to make that
 * one lean left. So, for example if we insert h in to this tree here, it comes
 * off as the left link of R so that gives us a temporary four node that's not
 * balanced so we need to rotate the link from S to the right and that gives us
 * now temporary four node that is balanced and again, these are all local
 * transformation it's not changing the rest of the tree. Now, we flip colors
 * and that gives us a, a good red-black tree, except that, that one red link
 * that we just is leaning the wrong way. So, now we need to rotate left and
 * then once we've done that, now we have a legal left-leaning red-black tree.
 */