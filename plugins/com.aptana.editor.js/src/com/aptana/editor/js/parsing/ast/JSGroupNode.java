package com.aptana.editor.js.parsing.ast;

import com.aptana.parsing.ast.IParseNode;

public class JSGroupNode extends JSPreUnaryOperatorNode
{
	/**
	 * JSGroupNode
	 * 
	 * @param start
	 * @param end
	 * @param expression
	 */
	public JSGroupNode(int start, int end, JSNode expression)
	{
		super(JSNodeTypes.GROUP, start, end, expression);
	}

	/*
	 * (non-Javadoc)
	 * @see com.aptana.editor.js.parsing.ast.JSNode#accept(com.aptana.editor.js.parsing.ast.JSTreeWalker)
	 */
	@Override
	public void accept(JSTreeWalker walker)
	{
		walker.visit(this);
	}
	
	/**
	 * getExpression
	 * 
	 * @return
	 */
	public IParseNode getExpression()
	{
		return this.getChild(0);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.aptana.editor.js.parsing.ast.JSUnaryOperatorNode#toString()
	 */
	public String toString()
	{
		StringBuilder buffer = new StringBuilder();
		IParseNode[] children = this.getChildren();

		buffer.append("("); //$NON-NLS-1$
		buffer.append(children[0]);
		buffer.append(")"); //$NON-NLS-1$

		this.appendSemicolon(buffer);

		return buffer.toString();
	}
}
